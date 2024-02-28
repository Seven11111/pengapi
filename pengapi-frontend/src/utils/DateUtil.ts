import moment from "moment";

const formatterTime = (val: any ) => {
  return val ? moment(val).format('YYYY-MM-DD HH:mm:ss') : ''
}

export default formatterTime;
