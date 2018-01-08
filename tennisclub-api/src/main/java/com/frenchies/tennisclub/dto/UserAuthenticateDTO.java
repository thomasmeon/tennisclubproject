package com.frenchies.tennisclub.dto;

//@Author Meon Thomas UCO 473449

public class UserAuthenticateDTO
{
    private String username;
    private String password;
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
