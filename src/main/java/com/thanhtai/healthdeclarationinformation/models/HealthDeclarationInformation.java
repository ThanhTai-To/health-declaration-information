package com.thanhtai.healthdeclarationinformation.models;



import com.thanhtai.healthdeclarationinformation.api.models.Address;
import com.thanhtai.healthdeclarationinformation.api.models.PersonalQuestionsLast14Days;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "healthDeclarationInformation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HealthDeclarationInformation {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
    private boolean isRegisterForOther;
    private String fullName;
    private String idCardNumber;
    private String birthYear;
    private String gender;
    private String nationality;
    private Address address;
    private String phone;
    private String email;
    private PersonalQuestionsLast14Days personalQuestionsLast14Days;
    @Setter(AccessLevel.NONE)
    @CreatedDate
    private String createdAt;
    @Setter(AccessLevel.NONE)
    @LastModifiedDate
    private String modifiedAt;
}
