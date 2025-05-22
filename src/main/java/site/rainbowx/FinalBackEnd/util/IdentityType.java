package site.rainbowx.FinalBackEnd.util;

import lombok.Getter;

@Getter
public enum IdentityType {
    GRADUATED_PARTY_MEMBER("已毕业党员"),
    FULL_PARTY_MEMBER("正式党员"),
    PROBATIONARY_PARTY_MEMBER("预备党员"),
    PARTY_APPLICANT("入党申请人"),
    ACTIVIST("入党积极分子"),
    DEVELOPMENT_TARGET("发展对象");

    private final String chineseName;

    IdentityType(String chineseName) {
        this.chineseName = chineseName;
    }

}

