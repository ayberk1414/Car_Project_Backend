package kodloma.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodloma.io.rentACar.business.abstracts.BrandService;
import kodloma.io.rentACar.business.requests.CreateBrandRequest;

import kodloma.io.rentACar.business.requests.UpdateBrandRequest;
import kodloma.io.rentACar.business.responses.GetAllBrandsResponse;
import kodloma.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Diş dunya acılan kısım
@RestController//Erişim noktası olduğunu anlıyo
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {
    private BrandService brandService;



    @GetMapping()// veri çekmek için kullanır
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getByid(id);
    }
    @PostMapping()//eklemeler için
    @ResponseStatus(code = HttpStatus.CREATED)//201 almak içn
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
    @PutMapping//Güncelemeler için kullanır
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

}
