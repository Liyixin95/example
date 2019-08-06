package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

/**
 * HttpVerticle
 *
 * @author liyixin
 * @date 2019/8/5
 */
public class HttpVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(req -> req.endHandler(v -> req.response().end()));
        httpServer.listen(80);
    }
}
