// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package taskqueuehelpers.actions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.webui.CustomJavaAction;
import com.mendix.logging.ILogNode;

public class DeleteGivenProcessedTasks extends CustomJavaAction<java.lang.Long>
{
	private java.util.List<IMendixObject> __Parameter;
	private java.util.List<taskqueuehelpers.proxies.ProcessedTask> Parameter;

	public DeleteGivenProcessedTasks(IContext context, java.util.List<IMendixObject> Parameter)
	{
		super(context);
		this.__Parameter = Parameter;
	}

	@java.lang.Override
	public java.lang.Long executeAction() throws Exception
	{
		this.Parameter = new java.util.ArrayList<taskqueuehelpers.proxies.ProcessedTask>();
		if (__Parameter != null)
			for (IMendixObject __ParameterElement : __Parameter)
				this.Parameter.add(taskqueuehelpers.proxies.ProcessedTask.initialize(getContext(), __ParameterElement));

		// BEGIN USER CODE
		else return 0L;
		
		IContext ctx = getContext();
		long recordsCount = this.__Parameter.size();
		List<IMendixIdentifier> ids = this.Parameter.stream().map(p -> Core.createMendixIdentifier(p.getOriginalMendixId())).collect(Collectors.toList());
		List<IMendixObject> originalObjects = Core.retrieveIdList(ctx, ids);
		boolean success = Core.delete(ctx, originalObjects);
		return success? recordsCount : 0;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "DeleteGivenProcessedTasks";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}