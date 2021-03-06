// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sftp.actions;

import com.jcraft.jsch.ChannelSftp;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import sftp.impl.SFTP;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Retrieve a file from the SFTP server and stores it as a Mendix FileDocument.
 */
public class Get extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String remoteFile;
	private IMendixObject __targetFile;
	private system.proxies.FileDocument targetFile;

	public Get(IContext context, java.lang.String remoteFile, IMendixObject targetFile)
	{
		super(context);
		this.remoteFile = remoteFile;
		this.__targetFile = targetFile;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.targetFile = __targetFile == null ? null : system.proxies.FileDocument.initialize(getContext(), __targetFile);

		// BEGIN USER CODE
		ChannelSftp channel = SFTP.getChannel(getContext());
		Core.storeFileDocumentContent(getContext(), targetFile.getMendixObject(), channel.get(this.remoteFile));
		return true;		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "Get";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
