package com.stc.petlove.services.DichVu;


import com.stc.petlove.dtos.DichVuDTO;
import com.stc.petlove.entities.DichVu;

import java.util.List;

public interface DichVuService {
    DichVu getDichVu(String id);
    DichVu create(DichVuDTO DTO);
    DichVu update(String id, DichVuDTO DTO);
    DichVu delete(String id);
    List<DichVu> getAllDichVu();
}
