package kodloma.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GetByIdBrandResponse {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class GetAllBrandsResponse {
        private int id;
        private String name;
    }
}
