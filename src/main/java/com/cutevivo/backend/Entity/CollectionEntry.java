package com.cutevivo.backend.Entity;

import javax.persistence.*;


/**
 * entryId：收藏条目ID
 * userid：进行收藏的用户ID
 * noteId：被收藏的笔记ID
 */
@Entity
@Table(name="t_collectionEntry")
public class CollectionEntry {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long entryId;
    private long userId;
    private long noteId;

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

}
