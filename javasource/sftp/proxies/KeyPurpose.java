// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package sftp.proxies;

public enum KeyPurpose
{
	SPECIFIC(new java.lang.String[][] { new java.lang.String[] { "en_US", "Specific" }, new java.lang.String[] { "nl_NL", "Specifiek" } }),
	GENERAL(new java.lang.String[][] { new java.lang.String[] { "en_US", "General" }, new java.lang.String[] { "nl_NL", "Algemeen" } });

	private java.util.Map<java.lang.String, java.lang.String> captions;

	private KeyPurpose(java.lang.String[][] captionStrings)
	{
		this.captions = new java.util.HashMap<java.lang.String, java.lang.String>();
		for (java.lang.String[] captionString : captionStrings)
			captions.put(captionString[0], captionString[1]);
	}

	public java.lang.String getCaption(java.lang.String languageCode)
	{
		if (captions.containsKey(languageCode))
			return captions.get(languageCode);
		return captions.get("en_US");
	}

	public java.lang.String getCaption()
	{
		return captions.get("en_US");
	}
}