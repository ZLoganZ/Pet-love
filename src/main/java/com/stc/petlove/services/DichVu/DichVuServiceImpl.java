package com.stc.petlove.services.DichVu;

import com.stc.petlove.dtos.DichVuDTO;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.exceptions.InvalidException;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DichVuServiceImpl implements DichVuService{

    private final DichVuRepository dichVuRepository;

    @Autowired
    public DichVuServiceImpl(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @Override
    public DichVu getDichVu(String id) {
        return dichVuRepository.findById(id).orElseThrow(()->new NotFoundException(String.format("Không tồn tại dịch vụ có mã id là: %s",id)));
    }

    @Override
    public DichVu create(DichVuDTO DTO) {
        if (ObjectUtils.isEmpty(DTO.getMaDichVu())){
            throw new InvalidException("Mã dịch vụ không được để trống");
        }
        if (ObjectUtils.isEmpty(DTO.getTenDichVu())){
            throw new InvalidException("Tên dịch vụ không được để trống");
        }
        if (ObjectUtils.isEmpty(DTO.getNoiDung())){
            throw new InvalidException("Nội dung không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getGiaDichVu())){
            throw new InvalidException("Giá dịch vụ không được để trống");
        }
        if(dichVuRepository.findByMaDichVu(DTO.getMaDichVu())){
            throw new InvalidException(String.format("Dịch vụ có mã %s đã tồn tại",DTO.getMaDichVu()));
        }
        DichVu dichVu = new DichVu();
        dichVu.setMaDichVu(DTO.getMaDichVu().trim());
        dichVu.setTenDichVu(DTO.getTenDichVu().trim());
        dichVu.setNoiDung(DTO.getNoiDung());
        dichVu.setGiaDichVu(DTO.getGiaDichVu());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu update(String id, DichVuDTO DTO) {
        DichVu dichVu = getDichVu(id);
        if (ObjectUtils.isEmpty(DTO.getMaDichVu())){
            throw new InvalidException("Mã dịch vụ không được để trống");
        }
        if (ObjectUtils.isEmpty(DTO.getTenDichVu())){
            throw new InvalidException("Tên dịch vụ không được để trống");
        }
        if (ObjectUtils.isEmpty(DTO.getNoiDung())){
            throw new InvalidException("Nội dung không được để trống");
        }
        if(ObjectUtils.isEmpty(DTO.getGiaDichVu())){
            throw new InvalidException("Giá dịch vụ không được để trống");
        }
        if(!dichVu.getMaDichVu().equalsIgnoreCase(DTO.getMaDichVu())&& dichVuRepository.findByMaDichVu(DTO.getMaDichVu())){
            throw new InvalidException(String.format("Dịch vụ có mã %s đã tồn tại",DTO.getMaDichVu()));
        }
        dichVu.setMaDichVu(DTO.getMaDichVu().trim());
        dichVu.setTenDichVu(DTO.getTenDichVu().trim());
        dichVu.setNoiDung(DTO.getNoiDung());
        dichVu.setGiaDichVu(DTO.getGiaDichVu());
        dichVuRepository.save(dichVu);
        return dichVu;
    }

    @Override
    public DichVu delete(String id) {
        DichVu dichVu = getDichVu(id);
        dichVuRepository.delete(dichVu);
        return dichVu;
    }

    @Override
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }
}
