package gateway.services;

import gateway.beans.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("gateway")
public class RestServer {

///////////////////////////////////////////////////////////////////////////////////
    // analyst API
    @Path("network-size")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNodesCount() {
        return Response.ok(Nodes.getInstance().getNodesSetSize()).build();
    }

    @Path("stats-count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatsCount() {
        return Response.ok(Stats.getInstance().getStatsSize()).build();
    }

    @Path("last-{n}-stats")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PM10> getRecentStats(@PathParam("n") int n) {
        if (n > Stats.getInstance().getStatsSize()) {
            n = Stats.getInstance().getStatsSize();
        }
        return Stats.getInstance().getLastNStats(n);
    }

    @Path("sd-and-mean-of-last-{n}-stats")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SDAndMean getSDAndMean(@PathParam("n") int n) {
        if (n > Stats.getInstance().getStatsSize()) {
            n = Stats.getInstance().getStatsSize();
        }
        double mean = Stats.getInstance().getMean(n);
        double SD = Stats.getInstance().getSD(n, mean);
        return new SDAndMean(SD, mean);
    }

///////////////////////////////////////////////////////////////////////////////////
    // nodes API
    @Path("add-node")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized Response addNode(Node node) {
        if (!Nodes.contains(node.getId())) {
            Nodes.getInstance().add(node);
            Publisher.getInstance().publish("A new node entered the network.");
            return Response.ok(Nodes.getInstance().getNodes()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Node was already in the network.").build();
        }
    }

    @Path("remove-node")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public synchronized Response removeNode(Node node) {
        Nodes.getInstance().remove(node.getId());
        Publisher.getInstance().publish("A node just left the network.");
        return Response.ok().build();
    }

    @Path("add-stat")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStat(PM10 stat) {
        Stats.getInstance().addStats(stat);
        Publisher.getInstance().publish("A new statistic has been added.");
        return Response.ok().build();
    }
}
