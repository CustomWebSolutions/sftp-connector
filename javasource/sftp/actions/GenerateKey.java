// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sftp.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import sftp.impl.SFTP;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class GenerateKey extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __key;
	private sftp.proxies.Key key;

	public GenerateKey(IContext context, IMendixObject key)
	{
		super(context);
		this.__key = key;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.key = __key == null ? null : sftp.proxies.Key.initialize(getContext(), __key);

		// BEGIN USER CODE
		SFTP.generateKeyContents(getContext(), key);
		SFTP.validateKey(getContext(), key);
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "GenerateKey";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
