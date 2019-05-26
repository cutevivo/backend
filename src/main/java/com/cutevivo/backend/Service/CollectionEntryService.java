package com.cutevivo.backend.Service;

import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.utils.ResultMessage;


public interface CollectionEntryService {

    ResultMessage getCollectionEntriesByUserId(long userId);
    ResultMessage addCollectionEntry(CollectionEntry collectionEntry);
    ResultMessage deleteCollectionEntry(CollectionEntry collectionEntry);
    ResultMessage getCollectionEntriesByNoteId(long noteId);
    boolean checkRepeat(long userId, long noteId);
}
