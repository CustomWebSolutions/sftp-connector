// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sftp.actions;

import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpATTRS;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import sftp.impl.SFTP;
import sftp.proxies.FileType;
import sftp.proxies.RemoteFile;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Retrieves a list of files and directories from the remote SFTP server as RemoteFile objects.
 */
public class List extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String path;

	public List(IContext context, java.lang.String path)
	{
		super(context);
		this.path = path;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		ChannelSftp channel = SFTP.getChannel(getContext());
		java.util.List<IMendixObject> result = new LinkedList<>();
		
		@SuppressWarnings("unchecked")
		Vector<ChannelSftp.LsEntry> list = channel.ls(path);
		for (ChannelSftp.LsEntry entry : list) {
			SftpATTRS attrs = entry.getAttrs();
			RemoteFile rf = new RemoteFile(getContext());
			rf.setPath(path);
			rf.setName(entry.getFilename());
			rf.setLastModificationDate(new Date(attrs.getMTime() * 1000L));
			rf.setSize(new Long(attrs.getSize()));
			
			if (attrs.isDir()) {
				rf.setFileType(FileType.Directory);
			} else if (attrs.isReg()) {
				rf.setFileType(FileType.File);
			}
			result.add(rf.getMendixObject());
		}
		
		return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "List";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
