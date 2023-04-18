package com.stc.petlove.services.LoaiThuCung;

import com.stc.petlove.dtos.LoaiThuCungDTO;
import com.stc.petlove.entities.LoaiThuCung;

import java.util.List;

public  interface LoaiThuCungService {

    LoaiThuCung getLoaiThuCung(String id);

    LoaiThuCung createLoaiThuCung(LoaiThuCungDTO DTO);

    LoaiThuCung updateLoaiThuCung(String id, LoaiThuCungDTO DTO);

    LoaiThuCung deleteLoaiThuCung(String id);

    List<LoaiThuCung> getAllLoaiThuCung();
}
