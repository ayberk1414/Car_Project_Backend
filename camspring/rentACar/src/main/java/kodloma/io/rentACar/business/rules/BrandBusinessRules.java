package kodloma.io.rentACar.business.rules;

import kodloma.io.rentACar.core.utilities.exceptions.BusinessException;
import kodloma.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExits(String name){
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException(" zaten O marka ismi var");//Java exception types
        }
    }
}
