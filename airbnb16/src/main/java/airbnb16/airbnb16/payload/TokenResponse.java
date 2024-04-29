package airbnb16.airbnb16.payload;

public class TokenResponse {;

    private String tokenType="Bearer";
    private String token;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
