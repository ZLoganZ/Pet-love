package com.stc.petlove.services.DatCho;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.dtos.DatChoDTO;

import java.util.List;

public interface DatChoService {
    DatCho getDatCho(String id);
    DatCho create(DatChoDTO DTO);
    DatCho update(String id, DatChoDTO DTO);
    DatCho delete(String id);
    List<DatCho> getAllDatCho();
}
