package com.cutevivo.backend.ServiceImpl;

import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.Repository.CollectionEntryRepository;
import com.cutevivo.backend.Service.CollectionEntryService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionEntryServiceImpl implements CollectionEntryService {

    @Autowired
    private CollectionEntryRepository collectionEntryRepository;

    public ResultMessage getCollectionEntriesByUserId(long userId){
        return collectionEntryRepository.findCollectionEntriesByUserId(userId);
    }

    public ResultMessage addCollectionEntry(CollectionEntry collectionEntry){
        return collectionEntryRepository.saveCollectionEntry(collectionEntry);
    }

    //not tested
    public ResultMessage deleteCollectionEntry(CollectionEntry collectionEntry){
        return collectionEntryRepository.deleteCollectionEntry(collectionEntry);
    }

    public ResultMessage getCollectionEntriesByNoteId(long noteId){
        return collectionEntryRepository.findCollectionEntriesByNoteId(noteId);
    }

    public boolean checkRepeat(long userId, long noteId){
        ResultMessage resultMessage = collectionEntryRepository.findCollectionEntriesByUserId(userId);
        List<CollectionEntry> collectionEntryList = (List<CollectionEntry>)resultMessage.getData();
        if(collectionEntryList.size() == 0){
            return false;
        }else{
            boolean result = false;
            for(CollectionEntry collectionEntry : collectionEntryList){
                if(noteId == collectionEntry.getNoteId()){
                    result = true;
                    break;
                }
            }
            return result;
        }

    }

}
