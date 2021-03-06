package com.thanhtai.healthdeclarationinformation.mappers;

import com.thanhtai.healthdeclarationinformation.api.models.Gender;
import com.thanhtai.healthdeclarationinformation.api.models.HealthDeclarationInformationModel;
import com.thanhtai.healthdeclarationinformation.api.models.Nationality;
import com.thanhtai.healthdeclarationinformation.models.HealthDeclarationInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper(uses = EnumMapper.class)
public interface HealthDeclarationInformationMapper {

    HealthDeclarationInformationMapper INSTANCE = Mappers.getMapper(HealthDeclarationInformationMapper.class);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gender", source = "request.gender",  qualifiedByName = "genderValue")
    @Mapping(target = "nationality", source = "request.nationality",  qualifiedByName = "nationalityValue")
    HealthDeclarationInformation toHealthDeclarationInformation(final HealthDeclarationInformationModel request);

    @Named("genderValue")
    default String genderValue(final Gender gender) {
        return Objects.isNull(gender) ? null : gender.toString();
    }

    @Named("nationalityValue")
    default String nationalityValue(final Nationality nationality) {
        return Objects.isNull(nationality) ? null : nationality.toString();
    }

    @Mapping(target = "gender", source = "healthDeclarationInformation.gender",  qualifiedByName = "genderEnum")
    @Mapping(target = "nationality", source = "healthDeclarationInformation.nationality",  qualifiedByName = "nationalityEnum")
    HealthDeclarationInformationModel toHealthDeclarationInformationModel(final HealthDeclarationInformation healthDeclarationInformation);

    @Named("genderEnum")
    default Gender genderEnum(final String gender) {
        return Objects.isNull(gender) ? null : Gender.valueOf(gender);
    }

    @Named("nationalityEnum")
    default Nationality nationalityEnum(final String nationality) {
        return Objects.isNull(nationality) ? null : Nationality.valueOf(nationality);
    }


}
