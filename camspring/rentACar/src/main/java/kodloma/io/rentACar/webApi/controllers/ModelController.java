package kodloma.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodloma.io.rentACar.business.abstracts.ModelService;
import kodloma.io.rentACar.business.requests.CreateBrandRequest;
import kodloma.io.rentACar.business.requests.CreateModelRequest;
import kodloma.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Erişim noktası olduğunu anlıyo
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;



    @GetMapping()// veri çekmek için kullanır
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()//eklemeler için
    @ResponseStatus(code = HttpStatus.CREATED)//201 almak içn
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
