package com.example.emutuelle.service;

import com.example.emutuelle.entity.Province;
import com.example.emutuelle.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    public Province createProvince(Province provinceDetails) {
        Province province = new Province();
        province.setCode(provinceDetails.getCode());
        province.setName(provinceDetails.getName());
        return provinceRepository.save(province);
    }

    public Province updateProvince(Long id, Province provinceDetails) {
        Province province = provinceRepository.findById(id).orElse(null);
        if (province != null) {
            province.setCode(provinceDetails.getCode());
            province.setName(provinceDetails.getName());
            return provinceRepository.save(province);
        }
        return null;
    }

    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }
}