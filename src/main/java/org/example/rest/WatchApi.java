package org.example.rest;

//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;

import io.swagger.annotations.Api;
import org.example.service.ServerWatch;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.management.OperatingSystemMXBean;

@Path("/watch")
@Api(value = "Watch", description = "Watch API.")
public class WatchApi {

    @Inject
    ServerWatch watch;

    @GET
    @Path("/health")
    //@ApiOperation(value = "health")
    //@ApiImplicitParams({@ApiImplicitParam(name = "id", paramType = "path", dataType = "int", required = true)})
    public Response health() {
        return Response.ok()
                .entity(String.format("Messages API is online since %s!", watch.getDateTime()))
                .build();
    }

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject info() {
        OperatingSystemMXBean osBean = this.watch.osInfo();
        return Json.createObjectBuilder().
                add("System Load Average", osBean.getSystemLoadAverage()).
                add("Available CPUs", osBean.getAvailableProcessors()).
                add("Architecture", osBean.getArch()).
                add("OS Name", osBean.getName()).
                add("Version", osBean.getVersion())
                .build();
    }

    @GET
    @Path("/memory")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject memory() {
        return Json.createObjectBuilder().
                add("Available Memory In MB", this.watch.availableMemoryInMB()).
                add("Used Memory In Mb At StartTime", this.watch.usedMemoryInMbAtStartTime()).
                add("Used Memory In Mb", this.watch.usedMemoryInMb())
                .build();
    }

}