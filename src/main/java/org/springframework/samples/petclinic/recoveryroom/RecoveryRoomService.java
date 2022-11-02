package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RecoveryRoomService {

    @Autowired
    RecoveryRoomRepository repo;
    
    public List<RecoveryRoom> getAll(){
        return repo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repo.getRecoveryRoomType(typeName);
    }

    @Transactional(rollbackFor=DuplicatedRoomNameException.class)
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        List<RecoveryRoom> rooms=getAll();
        for(RecoveryRoom r:rooms)
            if(r.getName().equals(p.getName()) && r.getRoomType().equals(p.getRoomType()) && !r.getId().equals(p.getId()))
                throw new DuplicatedRoomNameException();
        repo.save(p);
        return p;       
    }

    
}
