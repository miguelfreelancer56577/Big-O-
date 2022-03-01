package github.com.miguelfreelancer56577.patterns.factory;

import github.com.miguelfreelancer56577.patterns.factory.dto.CloudProvider;
import github.com.miguelfreelancer56577.patterns.factory.service.CloudService;

public class App {

	public static void main(String[] args) {
		CloudService cloudService = CloudFactory.getInstance(CloudProvider.AWS);
		cloudService.upload();
	}

}
