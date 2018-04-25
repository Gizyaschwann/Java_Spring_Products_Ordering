package io.innopolis.products.dto;

import javax.validation.constraints.NotEmpty;

public class UserOrderDto {
    @NotEmpty
    private Long id;

    @NotEmpty
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
