package github.com.miguelfreelancer56577.patterns.factorymethod;

import github.com.miguelfreelancer56577.patterns.factory.service.CloudService;
import github.com.miguelfreelancer56577.patterns.factorymethod.creator.impl.AwsProviderCreator;

public class App {

	public static void main(String[] args) {
		CloudProviderCreator creator = new AwsProviderCreator();
		CloudService cloudService = creator.getInstance();
		cloudService.upload();
	}

}
