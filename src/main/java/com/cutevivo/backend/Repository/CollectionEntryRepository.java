package com.cutevivo.backend.Repository;

import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollectionEntryRepository {

    @Autowired
    BaseRepository baseRepository;

    public ResultMessage findCollectionEntriesByUserId(long userId){
        return baseRepository.findByProperty(CollectionEntry.class, "userId", userId);
    }

    public ResultMessage saveCollectionEntry(CollectionEntry collectionEntry){
        return baseRepository.save(collectionEntry);
    }

    public ResultMessage deleteCollectionEntry(CollectionEntry collectionEntry){
        return baseRepository.delete(collectionEntry);
    }

    public ResultMessage findCollectionEntriesByNoteId(long noteId){
        return baseRepository.findByProperty(CollectionEntry.class, "noteId", noteId);
    }
}
