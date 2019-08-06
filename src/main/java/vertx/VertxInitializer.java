package vertx;

import common.Initializer;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

/**
 * VertxInitializer
 *
 * @author liyixin
 * @date 2019/8/5
 */
public class VertxInitializer implements Initializer {

    @Override
    public void init() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(HttpVerticle.class,new DeploymentOptions());
    }
}
