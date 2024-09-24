package spring;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.nio.file.Files;

public class Main {

	public static void main(String[] args) throws Exception {
		Server server = new Server(1337);
		WebAppContext handler = new WebAppContext();
		handler.setResourceBase(String.valueOf(Files.createTempDirectory("foo")));
		handler.setContextPath("/");
		handler.setAttribute(MetaInfConfiguration.CONTAINER_JAR_PATTERN, ".*\\.jar$|.*/classes/.*");
		handler.setConfigurations(new Configuration[] {new AnnotationConfiguration(), new MetaInfConfiguration()});
		server.setHandler(handler);
		server.start();
	}
}