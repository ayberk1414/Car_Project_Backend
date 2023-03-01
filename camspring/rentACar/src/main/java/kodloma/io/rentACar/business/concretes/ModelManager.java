package kodloma.io.rentACar.business.concretes;

import kodloma.io.rentACar.business.abstracts.ModelService;
import kodloma.io.rentACar.business.requests.CreateModelRequest;
import kodloma.io.rentACar.business.responses.GetAllBrandsResponse;
import kodloma.io.rentACar.business.responses.GetAllModelsResponse;
import kodloma.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodloma.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodloma.io.rentACar.entities.Model;
import kodloma.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models= modelRepository.findAll();
        List<GetAllModelsResponse>brandsResponses=models.stream().map(model->this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return  brandsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=modelMapperService.forrequest().map(createModelRequest,Model.class);
        modelRepository.save(model);
    }
}

