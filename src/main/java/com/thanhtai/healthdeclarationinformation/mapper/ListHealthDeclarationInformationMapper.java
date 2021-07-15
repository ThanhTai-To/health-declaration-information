//package com.thanhtai.healthdeclarationinformation.mapper;
//
//import com.thanhtai.healthdeclarationinformation.api.model.ListHealthDeclarationInformation;
//import com.thanhtai.healthdeclarationinformation.model.HealthDeclarationInformation;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//import org.springframework.data.domain.Page;
//
//import java.util.stream.Collectors;
//
//@Mapper
//public abstract class ListHealthDeclarationInformationMapper {
//
//    ListHealthDeclarationInformationMapper INSTANCE = Mappers.getMapper(ListHealthDeclarationInformationMapper.class);
//
//    public ListHealthDeclarationInformation toListHealthDeclarationInformation(
//            Page<HealthDeclarationInformation> healthDeclarationInfos) {
//        ListHealthDeclarationInformation listHealthDeclarationInformation =
//                new ListHealthDeclarationInformation();
//
//        listHealthDeclarationInformation
//                .setCurrentPage(healthDeclarationInfos.getNumber());
//        listHealthDeclarationInformation
//                .setTotalPage(healthDeclarationInfos.getTotalPages());
//        listHealthDeclarationInformation
//                .setTotalElements(healthDeclarationInfos.getNumberOfElements());
//
//        listHealthDeclarationInformation
//                .setHealthDeclarationInformations(
//                        healthDeclarationInfos.stream()
//                                .map(HealthDeclarationInformationMapper.INSTANCE::toHealthDeclarationInformationModel)
//                                .collect(Collectors.toList())
//                );
//
//        return listHealthDeclarationInformation;
//    }
//
//}


package com.thanhtai.healthdeclarationinformation.mapper;

import com.thanhtai.healthdeclarationinformation.api.model.ListHealthDeclarationInformation;
import com.thanhtai.healthdeclarationinformation.model.HealthDeclarationInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

@Mapper
public interface ListHealthDeclarationInformationMapper {

    ListHealthDeclarationInformationMapper INSTANCE = Mappers.getMapper(ListHealthDeclarationInformationMapper.class);

    default ListHealthDeclarationInformation toListHealthDeclarationInformation(
            Page<HealthDeclarationInformation> healthDeclarationInfos) {
        ListHealthDeclarationInformation listHealthDeclarationInformation =
                new ListHealthDeclarationInformation();

        listHealthDeclarationInformation
                .setCurrentPage(healthDeclarationInfos.getNumber());
        listHealthDeclarationInformation
                .setTotalPage(healthDeclarationInfos.getTotalPages());
        listHealthDeclarationInformation
                .setTotalElements(healthDeclarationInfos.getNumberOfElements());

        listHealthDeclarationInformation
                .setHealthDeclarationInformations(
                        healthDeclarationInfos.stream()
                                .map(HealthDeclarationInformationMapper.INSTANCE::toHealthDeclarationInformationModel)
                                .collect(Collectors.toList())
                );

        return listHealthDeclarationInformation;
    }

}
