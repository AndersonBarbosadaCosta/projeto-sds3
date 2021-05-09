import axios from 'axios';
import Chart from 'react-apexcharts';
import { BASE_URL } from 'utils/requests';
import { SaleSum } from 'types/sale';

type ChartData = {
    series: number[];
    labels: string[];
}

const DonutChart = () => {

    let chartData: ChartData = { series: [], labels: [] };

    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const mySeries = response.data.map(item => item.sum);
            const myLabels = response.data.map(item => item.sellerName);
            chartData = { mySeries, myLabels }

        })
    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
};

export default DonutChart;