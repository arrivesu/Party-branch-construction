package site.rainbowx.FinalBackEnd.dto;

public enum RoleDTO {
    ADMIN("admin"),
    MEMBER("member");

    private final String role;

    RoleDTO(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
