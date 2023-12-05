package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentDto;
import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import ma.youcode.rentalhive.service.CategoryService;
import ma.youcode.rentalhive.service.EquipmentService;
import ma.youcode.rentalhive.service.ManufactorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private EquipmentDao equipmentDao;
    private CategoryService categoryService;
    private ManufactorerService manufactorerService;

    @Autowired
    public EquipmentServiceImpl(EquipmentDao equipmentDao,
                                CategoryService categoryService,
                                ManufactorerService manufactorerService) {
        this.equipmentDao = equipmentDao;
        this.categoryService = categoryService;
        this.manufactorerService = manufactorerService;
    }

    public EquipmentServiceImpl() {
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        checkEquipmentIfExist(equipment.getName());
        Category category = checkCategoryIfExistForCreateEquipment(equipment.getCategory().getId());
        Manufacturer manufacturer = fetshOrCreateEquipmentManufactorer(equipment.getManufacturer().getManufacturer());
        equipment.setCategory(category);
        equipment.setManufacturer(manufacturer);
        validateEquipment(equipment);
        return equipmentDao.save(equipment);
    }
    @Override
    public Equipment updateEquipment(Long id, EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment();
        equipment.setId(id);
        equipment.setName(equipmentDto.name());
        equipment.setPricePerDay(equipmentDto.pricePerDay());
        equipment.setQuantity(equipmentDto.quantity());
        equipment.setPricePerDay(equipmentDto.pricePerDay());
        Category category1 = new Category();
        category1.setId(equipmentDto.category().id());
        equipment.setCategory(category1);
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setManufacturer(equipmentDto.manufacturerName());
        equipment.setManufacturer(manufacturer1);

        Category category = checkCategoryIfExistForCreateEquipment(equipment.getCategory().getId());
        Manufacturer manufacturer = fetshOrCreateEquipmentManufactorer(equipment.getManufacturer().getManufacturer());
        equipment.setCategory(category);
        equipment.setManufacturer(manufacturer);
        validateEquipment(equipment);
        return equipmentDao.save(equipment);
    }

    @Override
    public Page<Equipment> fetchAllEquipment(Pageable pageable) {
        return equipmentDao.findAll(pageable);
    }

    @Override
    public List<Equipment> searchEquipmentDisponible(Equipment equipment, LocalDateTime dateTime) {
        return null;
    }

    @Override
    public void checkEquipmentIfExist(String name) {
        Optional<Equipment> equipment = equipmentDao.findByName(name);
        if(equipment.isPresent()){
            throw new RuntimeException("equipment already exist, just do update");
        }
    }

    @Override
    public Category checkCategoryIfExistForCreateEquipment(Long category_id) {
        Optional<Category> category = categoryService.searchCategory(category_id);
        if(category.isPresent()){
            return category.get();
        }
        throw new RuntimeException("category does not exist");
    }
    @Override
    public Manufacturer fetshOrCreateEquipmentManufactorer(String manufacturer_name) {
        Optional<Manufacturer> manufacturerSearched = manufactorerService.searchManufactorer(manufacturer_name);
        if(manufacturerSearched.isPresent()){
            return manufacturerSearched.get();
        }
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setManufacturer(manufacturer_name);
        return manufactorerService.createManufactorer(manufacturer1);
    }
    @Override
    public void validateEquipment(Equipment equipment) {
        if(equipment.getName() == null || equipment.getName().isEmpty() || equipment.getName().isBlank())
            throw new IllegalArgumentException("name of equipment is null or blank or empty");
        if( equipment.getPricePerDay() == null || equipment.getPricePerDay().toString().isEmpty() || equipment.getPricePerDay().toString().isBlank())
            throw new IllegalArgumentException("name of equipment is null or blank or empty");
        if(equipment.getQuantity() == null || equipment.getQuantity().toString().isEmpty() || equipment.getQuantity().toString().isBlank())
            throw new IllegalArgumentException("name of equipment is null or blank or empty");
        if(equipment.getCategory() == null || equipment.getCategory().toString().isEmpty() || equipment.getCategory().toString().isBlank())
            throw new IllegalArgumentException("name of equipment is null or blank or empty");
        if(equipment.getManufacturer() == null || equipment.getManufacturer().toString().isEmpty() || equipment.getManufacturer().toString().isBlank())
            throw new IllegalArgumentException("name of equipment is null or blank or empty");
    }

    @Override
    public void validateEquipment() {

    }
//    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
//        String FOLDER_PATH = "C:upload\" + file.getOriginalFilename();
//        String filePath= FOLDER_PATH + file.getOriginalFilename();
//        FileData data = FileData.builder()
//                .type(typeFile.photo.toString())
//                .filePath(filePath).build();
//
//        FileData fileData=fileDataRepository.save(data);
//
//        file.transferTo(new File(FOLDER_PATH));
//
//        if (fileData.getId() != null) {
//            return "file uploaded successfully : " + filePath;
//        }
//        return null;
//    }
}