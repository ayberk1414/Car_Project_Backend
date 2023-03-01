package kodloma.io.rentACar.business.abstracts;

import kodloma.io.rentACar.business.requests.CreateBrandRequest;
import kodloma.io.rentACar.business.requests.CreateModelRequest;
import kodloma.io.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
