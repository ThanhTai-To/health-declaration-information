package com.thanhtai.healthdeclarationinformation.model;


import com.thanhtai.healthdeclarationinformation.api.model.Address;
import com.thanhtai.healthdeclarationinformation.api.model.PersonalQuestionsLast14Days;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "healthDeclarationInformation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HealthDeclarationInformation {
    @Id
    @Getter
    private String id;
    @Setter
    @Getter
    private boolean isRegisterForOther;
    @Setter
    @Getter
    private String fullName;
    @Setter
    @Getter
    private String idCardNumber;
    @Setter
    @Getter
    private String birthYear;
    @Setter
    @Getter
    private String gender;
    @Setter
    @Getter
    private String nationality;
    @Setter
    @Getter
    private Address address;
    @Setter
    @Getter
    private String phone;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private PersonalQuestionsLast14Days personalQuestionsLast14Days;
    @Getter
    @CreatedDate
    private String createdAt;
    @Getter
    @LastModifiedDate
    private String modifiedAt;
}
