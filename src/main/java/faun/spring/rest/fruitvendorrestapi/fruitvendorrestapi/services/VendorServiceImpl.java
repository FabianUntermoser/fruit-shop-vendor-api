package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.mapper.VendorMapper;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.exceptions.ResourceNotFoundException;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendorMapper::vendorToVendorDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO addVendor(VendorDTO vendor) {
        Vendor converted = vendorMapper.vendorDTOtoVendor(vendor);
        Vendor saved = vendorRepository.save(converted);
        return vendorMapper.vendorToVendorDTO(saved);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public VendorDTO updateVendorById(Long id, VendorDTO vendorDTO) {
        vendorDTO.setId(id);
        Vendor vendor = vendorMapper.vendorDTOtoVendor(vendorDTO);
        Vendor savedVendor = vendorRepository.save(vendor);
        return vendorMapper.vendorToVendorDTO(savedVendor);
    }

    @Override
    public VendorDTO updateFieldsInVendorById(Long id, VendorDTO vendorDTO) {
        Vendor updatedVendor = vendorRepository.findById(id)
                .map(vendor -> updateVendorFields(vendor, vendorDTO))
                .orElseThrow(ResourceNotFoundException::new);

        Vendor savedVendor = vendorRepository.save(updatedVendor);

        return vendorMapper.vendorToVendorDTO(savedVendor);
    }

    private Vendor updateVendorFields(Vendor old, VendorDTO latest) {
        if (latest == null) return old;

        if (latest.getName() != null)
            old.setName(latest.getName());
        return old;
    }

}
