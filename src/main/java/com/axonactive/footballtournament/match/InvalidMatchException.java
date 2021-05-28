package com.axonactive.footballtournament.match;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class InvalidMatchException extends WebApplicationException{

    public InvalidMatchException() {
        super(MatchMessage.INVALID_MATCH, Status.BAD_REQUEST);
    }
    
}
