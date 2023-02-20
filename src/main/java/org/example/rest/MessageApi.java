package org.example.rest;

//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;
import org.example.model.Message;

import java.util.ArrayList;
import java.util.List;

@Path("/api")
@Api(value = "Messages", description = "Messages API.")
public class MessageApi {

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Message.class)})
    public Response getAllMessages() {
        List<Message> messageList = new ArrayList<>();
        messageList.add(newMessage(1));
        messageList.add(newMessage(2));
        messageList.add(newMessage(3));
        return Response.status(Response.Status.OK)
                .entity(messageList).build();
    }

    @GET
    @Path("/messages/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Message.class)})
    public Response getMessage(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                .entity(newMessage(id)).build();
    }

    @POST
    @Path("/messages")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "OK", response = Message.class)})
    public Response createMessage(Message message) {
        return Response.status(Response.Status.CREATED)
                .entity(message).build();
    }

    @PUT
    @Path("/messages")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "OK", response = Message.class)})
    public Response updateMessage(Message message) {
        return Response.status(Response.Status.OK)
                .entity(message).build();
    }

    @DELETE
    @Path("/messages/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 202, message = "OK", response = Message.class)})
    public Response deleteMessage(@PathParam("id") int id) {
        return Response.status(Response.Status.ACCEPTED)
                .entity(newMessage(id)).build();
    }

    private Message newMessage(int id) {
        return new Message(id, "user_" + id, String.format("message from user_%s!", id));
    }

}