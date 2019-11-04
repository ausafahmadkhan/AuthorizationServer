package com.example.OAuthServer.Persistence.Models;

public enum Permissions
{
    WRITE("WRITE"),
    READ("READ");

    private String val;

    Permissions(String val)
    {
        this.val = val;
    }

    public String getVal()
    {
        return this.val;
    }
}
