package com.lzf.erp.dao;

import java.util.List;

import com.lzf.erp.model.InBuyOrderDetail;

/**@文件名: InBuyConteactDetailDao.java
 * @类功能说明: 合同明细表详情
 * @作者: YangFan
 * @Email: 
 * @日期: 2019年5月20日下午2:24:13
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: YangFan</li> 
 * 	 <li>日期: 2019年5月20日下午2:24:13</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface InBuyOrderDetailDao {
 
	/**@方法名: queryInBuyOrderDetailByInsiid
	 * @方法说明: 根据合同主表id查询 合同详细表详情
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月20日下午2:29:09
	 * @param insiid
	 * @return
	 * @return: List<InBuyOrderDetail>
	 */
	public List<InBuyOrderDetail> queryInBuyOrderDetailByInsiid(int insiid);

	/**@方法名: addInBuyOrderDetail
	 * @方法说明: 添加子表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日上午11:33:04
	 * @param inBuyOrderDetail
	 * @return: void
	 */
	public void addInBuyOrderDetail(InBuyOrderDetail inBuyOrderDetail);

	/**@方法名: deleteInBuyOrderDetail
	 * @方法说明: 根据主表id删除子表信息
	 * @作者: YangFan
	 * @邮箱：
	 * @日期: 2019年5月21日下午2:21:11
	 * @param inbodid
	 * @return: void
	 */
	public void deleteInBuyOrderDetail(int inbodid);
}
