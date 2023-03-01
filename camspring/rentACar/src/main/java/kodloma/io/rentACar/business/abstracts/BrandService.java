package kodloma.io.rentACar.business.abstracts;

import kodloma.io.rentACar.business.requests.CreateBrandRequest;

import kodloma.io.rentACar.business.requests.UpdateBrandRequest;
import kodloma.io.rentACar.business.responses.GetAllBrandsResponse;
import kodloma.io.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse>getAll();
    GetByIdBrandResponse getByid( int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);


}
