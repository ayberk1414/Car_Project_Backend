package kodloma.io.rentACar.business.concretes;

import jakarta.persistence.Id;
import kodloma.io.rentACar.business.abstracts.BrandService;
import kodloma.io.rentACar.business.requests.CreateBrandRequest;

import kodloma.io.rentACar.business.requests.UpdateBrandRequest;
import kodloma.io.rentACar.business.responses.GetAllBrandsResponse;
import kodloma.io.rentACar.business.responses.GetByIdBrandResponse;
import kodloma.io.rentACar.business.rules.BrandBusinessRules;
import kodloma.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodloma.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodloma.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAll() {
    List<Brand>brands= brandRepository.findAll();
    List<GetAllBrandsResponse>brandsResponses=brands.stream().map(brand->this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return  brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getByid(int id) {
        Brand brand= this.brandRepository.findById(Long.valueOf(id)).orElseThrow();
        GetByIdBrandResponse response= this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExits(createBrandRequest.getName());
    Brand brand=modelMapperService.forrequest().map(createBrandRequest,Brand.class);
    brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=modelMapperService.forrequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);//id olduğu icin save update yapti
    }

    @Override
    public void delete(int id) {
 this.brandRepository.deleteById((long) id);
    }


}

