package org.test.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.test.model.domain.Person;
import org.test.model.repository.PersonRepository;

@Path("/person")
public class PersonResource {

    @Inject
    private PersonRepository repository;


    @Operation(
        description = "Get a list of all people in the database"
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200",
                    description = "A list of People",
                    content = @Content(schema = @Schema(implementation = Person.class))
                    ),
            @APIResponse(
                responseCode = "500",
                description = "An unknown error occurred"
            ),
            @APIResponse(
                responseCode = "400",
                description = "The request could not be processed because of the specified inputs. The cause could be a validation issue or other problem with the data"
            )
            
        }
    )
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        List<Person> persons = this.repository.findAllPersons();
        return persons;
    }


    @Operation(
        description = "Get a person by it's ID"
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200",
                    description = "A Person matching the specified ID, if any is found on the database",
                    content = @Content(schema = @Schema(implementation = Person.class))
                    ),
            @APIResponse(
                responseCode = "500",
                description = "An unknown error occurred"
            ),
            @APIResponse(
                responseCode = "400",
                description = "The request could not be processed because of the specified inputs. The cause could be a validation issue or other problem with the data"
            )
            
        }
    )
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Person getPersonById(
            @Parameter(
                description = "The ID of the person to look for", required = true) @PathParam("id") String id) {
         Person person = this.repository.findByPersonId(id);
        return person;
    }


    @Operation(
        description = "Add a new person to the database"
    )
    @APIResponses(
        value = {
            @APIResponse(responseCode = "200",
                    description = "The new person generated",
                    content = @Content(schema = @Schema(implementation = Person.class))
                    ),
            @APIResponse(
                responseCode = "500",
                description = "An unknown error occurred"
            ),
            @APIResponse(
                responseCode = "400",
                description = "The request could not be processed because of the specified inputs. The cause could be a validation issue or other problem with the data"
            )
            
        }
    )
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person newPerson( @Valid Person Person){
        return this.repository.persistAndReturn(Person);
    }
    
}