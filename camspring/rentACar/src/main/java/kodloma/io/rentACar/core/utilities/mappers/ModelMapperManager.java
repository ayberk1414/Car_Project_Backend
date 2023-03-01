package kodloma.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;


import org.modelmapper.ModelMapper;
@Service
@AllArgsConstructor

public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.modelMapper;
    }

    @Override
    public ModelMapper forrequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }
}
