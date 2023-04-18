package com.stc.petlove.services.TaiKhoan;

import com.stc.petlove.dtos.TaiKhoanDTO;
import com.stc.petlove.entities.TaiKhoan;

import java.util.List;

public interface TaiKhoanService {
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan create(TaiKhoanDTO DTO);
    TaiKhoan update(String id,TaiKhoanDTO DTO);
    TaiKhoan delete(String id);
    List<TaiKhoan> getAllTaiKhoan();
}
