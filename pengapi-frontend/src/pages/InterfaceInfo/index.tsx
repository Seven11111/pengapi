import { PageContainer } from '@ant-design/pro-components';
import {Button, Card, Descriptions, Divider, Form, message, Spin} from 'antd';
import React, { useEffect, useState } from 'react';

import {
  getinterfaceInfoVoByIdUsingGet,
  invokeInterfaceInfoUsingPost,
} from '@/services/pengapi-backend/interfaceInfoController';
import formatterTime from '@/utils/DateUtil';
import { useParams } from '@@/exports';
import { hide } from '@floating-ui/dom';
import TextArea from 'antd/es/input/TextArea';

/**
 * 主页
 * @constructor
 */
const Index: React.FC = () => {
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState<API.InterfaceInfo>();
  const [invokeRes, setInvokeRes] = useState<any>();
  const [invokeLoading, setInvokeLoading] = useState(false);
  const params = useParams();

  const loadData = async (current = 1, pageSize = 5) => {
    if (!params.id) {
      message.error('参数不存在');
      return;
    }
    try {
      setLoading(true);
      const res = await getinterfaceInfoVoByIdUsingGet({
        id: Number(params.id),
      });
      setData(res.data);
    } catch (error: any) {
      hide();
      message.error('加载失败,' + error.message);
      return false;
    }
    setLoading(false);
  };

  useEffect(() => {
    loadData();
  }, []);

  const onFinish = async (values: any) => {
    if (!params.id) {
      message.error('参数不存在');
      return;
    }
    try {
      setInvokeLoading(true);
      const res = await invokeInterfaceInfoUsingPost({
        id: params.id,
        ...values,
      });
      console.log(res);
      setInvokeRes(res.data);
      message.success('调用成功');
    } catch (error: any) {
      hide();
      message.error('调用失败,' + error.message);
      return false;
    }
    setInvokeLoading(false);
  };

  return (
    <PageContainer title={'查看接口文档'}>
      {data ? (
        <Card>
          <Descriptions title={data.name} column={1} >
            <Descriptions.Item label="接口状态">{data.status ? '开启' : '关闭'}</Descriptions.Item>
            <Descriptions.Item label="描述">{data.description}</Descriptions.Item>
            <Descriptions.Item label="请求地址">{data.url}</Descriptions.Item>
            <Descriptions.Item label="请求方法">{data.method}</Descriptions.Item>
            <Descriptions.Item label="请求头">{data.requestHeader}</Descriptions.Item>
            <Descriptions.Item label="请求参数">{data.requestParams}</Descriptions.Item>
            <Descriptions.Item label="响应头">{data.responseHeader}</Descriptions.Item>
            <Descriptions.Item label="创建时间">{formatterTime(data.createTime)}</Descriptions.Item>
            <Descriptions.Item label="更新时间">{formatterTime(data.updateTime)}</Descriptions.Item>
          </Descriptions>
        </Card>
      ) : (
        <>接口不存在</>
      )}
      <Divider />
      <Card title={"在线测试"}>
        <Form name="invoke" onFinish={onFinish} layout={'vertical'}>
          <Form.Item name="userRequestParams" label="请求参数">
            <TextArea />
          </Form.Item>
          <Form.Item wrapperCol={{ span: 16 }}>
            <Button type="primary" htmlType="submit">
              调用
            </Button>
          </Form.Item>
        </Form>
      </Card>
      <Divider />
      <Card title={"调用结果"} loading={invokeLoading}>
        {invokeRes}
      </Card>
    </PageContainer>
  );
};

export default Index;
