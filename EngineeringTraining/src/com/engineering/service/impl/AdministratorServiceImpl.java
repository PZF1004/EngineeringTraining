package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IAdministratorDao;
import com.engineering.dao.impl.AdministratorDaoImpl;
import com.engineering.entity.Administrator;
import com.engineering.service.IAdministratorService;

public class AdministratorServiceImpl implements IAdministratorService {

	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	IAdministratorDao administratordao = new AdministratorDaoImpl();

	// ����Աע��
	public boolean addAdministrator(Administrator administrator) {
		if (!administratordao.isExist(administrator.getAdminID())) { // ����������÷�������
			return administratordao.addAdministrator(administrator); // ���ӣ�����Dao�㽫�ɹ���Ϣ���ظ�service
		} else { // ����
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}

	// ɾ������Ա��Ϣ�����ݴ�����adminID��
	public boolean deleteAdministrator(String adminID) {
		if (administratordao.isExist(adminID)) {
			return administratordao.deleteAdministrator(adminID);
		} else {
			return false;
		}
	}

	// �޸Ĺ���Ա��Ϣ�����ݴ�����adminID��
	public boolean updateAdministrator(String adminID, Administrator administrator) {
		if (administratordao.isExist(adminID)) {
			return administratordao.updateAdministrator(adminID, administrator);
		} else {
			return false;
		}
	}

	// ��ѯ����Ա��Ϣ�����ݴ�����adminID��
	public Administrator queryAdministrator(String adminID) {
		return administratordao.queryAdministrator(adminID);
	}

	// ��ѯȫ������Ա��Ϣ(ͨ��List����)
	public List<Administrator> queryAllAdministrators() {
		return administratordao.queryAllAdministrators();
	}

}
