package altio;

import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import java.io.File;

public class CustomEglFileGeneratingTemplateFactory extends EglFileGeneratingTemplateFactory {
	public void setOutputRoot(String path) throws EglRuntimeException {
		File outputRoot = new File(path);
		if (!outputRoot.exists()) {
			if (!outputRoot.mkdir()) {
				throw new EglRuntimeException(new EolRuntimeException("Unable to create output directory"));
			}
		} else if (!outputRoot.isDirectory()) {
			throw new EglRuntimeException(new EolRuntimeException("Output path must be a directory"));
		}
		this.outputRootPath = outputRoot.getAbsolutePath();
		this.outputRoot = outputRoot.toURI();
	}
}