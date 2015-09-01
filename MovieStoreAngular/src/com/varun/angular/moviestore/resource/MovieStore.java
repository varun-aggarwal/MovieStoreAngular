package com.varun.angular.moviestore.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.varun.angular.moviestore.domain.Address;
import com.varun.angular.moviestore.domain.User;
import com.varun.angular.moviestore.domain.dto.AddressDto;
import com.varun.angular.moviestore.service.UserDetailService;

@Path("/user")
public class MovieStore {

    static final String ADDRESS_PATH = "/address";
    private UserDetailService userDetailService = new UserDetailService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        User user = null;
        user = userDetailService.getUserData();
        Gson gson = new Gson();
        return Response.ok().entity(gson.toJson(user)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(ADDRESS_PATH)
    public Response postNewAddress(final AddressDto newAddress) {
        Address address = new Address();
        address.setAddressName(newAddress.getAddressName());
        address.setPostcode(newAddress.getPostcode());
        address.setStreet(newAddress.getStreet());
        userDetailService.addAddressForUser(address);
        System.out.println(userDetailService.getUserData());
        return Response.ok().entity("success").build();
    }
}
