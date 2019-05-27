package com.lzf.erp.dao;

import java.util.List;

import com.lzf.erp.model.InsupplierInfo;
import com.lzf.erp.model.InsupplierLinkMan;

public interface InsupplierLinkManDao {
	
	
	/**@方法名: findInsupplierLinkmanByInscid
	 * @方法说明: 通过主表id查询 供应商联系人信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:37:45
	 * @param inscid
	 * @return
	 * @return: List<InsupplierLinkMan>
	 */
	public List<InsupplierLinkMan> findInsupplierLinkmanByInscid(int inscid);

	/**@方法名: addInsupplierLinkMan
	 * @方法说明: 添加联系人信息   
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午9:38:13
	 * @param insupplierLinkMan
	 * @return: void
	 */
	public void addInsupplierLinkMan(InsupplierLinkMan insupplierLinkMan);

	/**@方法名: deleteInsupplierLinkManByInsiid
	 * @方法说明: 根据主表id删除对应的信息表
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午10:04:41
	 * @param insiid
	 * @return: void
	 */
	public void deleteInsupplierLinkManByInsiid(Integer insiid);

	/**@方法名: deleteInsupplierLinkMan
	 * @方法说明: 根据主表id删除 联系人信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月14日上午10:08:51
	 * @param insiid
	 * @return: void
	 */
	public void deleteInsupplierLinkMan(int insiid);

}
